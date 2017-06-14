from django.conf.urls import url
from django.views.decorators.cache import cache_page

from rest_framework import routers
from events import apis

event_routers = routers.SimpleRouter()

event_routers.register('', apis.EventView, 'event')
event_routers.register('matches', apis.UserEventMatchView, 'event_matches')

urlpatterns = event_routers.urls
