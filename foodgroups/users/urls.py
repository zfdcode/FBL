from django.conf.urls import url
from django.views.decorators.cache import cache_page

from rest_framework import routers
from users import apis

user_routers = routers.SimpleRouter()

user_routers.register('all-preferences', apis.FoodPreferenceView, 'preference')
user_routers.register('user-preferences', apis.UserFoodPreferenceView, 'user_preference')

urlpatterns = user_routers.urls
