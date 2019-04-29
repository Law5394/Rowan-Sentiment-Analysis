from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
import json
import requests

import twitter_credentials


class StdOutListener(StreamListener):

    def process_tweet(self, data):
        extended_tweet = data['truncated']

        if extended_tweet:
            text = data['extended_tweet']['full_text']
        else:
            text = data['text']

        tweet_id = data['id']
        date = data['created_at']
        user_id = data['user']['id']
        user_screen_name = data['user']['screen_name']

        payload = {
            'tweet_id': tweet_id,
            'date': date,
            'text': text,
            'user_id': user_id,
            'user_screen_name': user_screen_name
        }
        return payload

    def post_to_lambda(self, payload):
        url = 'lamndaEndPointUrl'
        requests.post(url, data=json.dumps(payload))

        return True

    def on_data(self, data):
        json_load = json.loads(data)
        payload = self.process_tweet(json_load)
        self.post_to_lambda(payload)
        return True

    def on_error(self, status):
        print(status)


if __name__ == "__main__":

    listener = StdOutListener()
    auth = OAuthHandler(twitter_credentials.CONSUMER_KEY,
                        twitter_credentials.CONSUMER_SECRET)
    auth.set_access_token(twitter_credentials.ACCESS_TOKEN,
                          twitter_credentials.ACESS_SECRET)

    stream = Stream(auth, listener)
    stream.filter(track=['#rowan, #rowanproud', '@RowanUniversity',
                         '@RowanSCCA', '#Rowan2019', 'Rowan University',
                         '@RowanAlumni', '#RowanAlumni', 'Rowan Advisory',
                         '@RowanGlobal', '@RowanAthletics', '@RowanCampusRec',
                         '#HumansOfRowan', '@RowanNews'])
