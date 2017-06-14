from rest_framework import (
    mixins,
    status
)
from rest_framework.response import Response

from commons import views as common_views
from events import (
    models,
    serializers
)


class UserEventMatchView(
    mixins.ListModelMixin,
    common_views.BaseGenericViewSet
):
    """
    Class which contain all REST APIs related to Event Matches of a User
    """
    model = models.Event
    serializer_class = serializers.EventSerializer
    queryset = models.Event.objects.all()[:1]


class EventView(
    mixins.ListModelMixin,
    common_views.BaseGenericViewSet
):
    """
    Class which contain all REST APIs related to Events
    """
    model = models.Event
    serializer_class = serializers.EventSerializer
    queryset = models.Event.objects.all()
