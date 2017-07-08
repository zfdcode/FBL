from rest_framework.authentication import BasicAuthentication


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

    def authenticate_credentials(self, userid, password):
        """
        Authenticate the userid and password against username and password.
        """
        user_names = {
            "1": 'Frodo',
            "2": 'Sam',
            "3": 'Tom',
            "4": 'Jerry',
            "5": 'Mickey',
            "6": 'Donald',
            "7": 'Goofy',
            "8": 'Pluto',
            "9": 'Popeye',
            "10": 'Bruno'
        }

        # # Do some authentication from JAVA API here and get user data
        # #

        # Create User
        user = User()
        user.user_id=userid
        user.name=user_names.get(userid, 'Sam')

        return user, None
