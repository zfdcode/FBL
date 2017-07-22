import requests

from django.conf import settings

from rest_framework.authentication import BasicAuthentication
from rest_framework.exceptions import AuthenticationFailed


class User(object):
    user_id = None
    name = None

    @property
    def is_anonymous(self):
        return False

    @property
    def is_authenticated(self):
        return True


class FBLAuthentication(BasicAuthentication):
    """
    Authenticate User from JAVA User Auth API
    """
    def authenticate_credentials(self, userid, password):
        """
        Authenticate the userid and password against username and password.
        """
        # user_names = {
        #     "1": 'Frodo',
        #     "2": 'Sam',
        #     "3": 'Tom',
        #     "4": 'Jerry',
        #     "5": 'Mickey',
        #     "6": 'Donald',
        #     "7": 'Goofy',
        #     "8": 'Pluto',
        #     "9": 'Popeye',
        #     "10": 'Bruno'
        # }

        # # Do some authentication from JAVA API here and get user data
        # #
        response = requests.get(
            "{}/auth/id/{}".format(
                settings.JAVA_API_URL,
                userid
            ),
            params={"password": password}
        )
        if response.status_code == 200:
            java_user_id = response.text
            # Create User
            user = User()
            user.user_id = java_user_id
            # user.name = user_names.get(userid, 'Sam')
        else:
            raise AuthenticationFailed('Invalid username/password.')

        return user, None
