from rest_framework import (
    mixins,
)
from rest_framework.decorators import list_route
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

    def get_serializer_context(self):
        context = super(UserEventMatchView, self).get_serializer_context()
        context.update({
            'is_list': True
        })
        return context


class EventView(
    mixins.ListModelMixin,
    mixins.RetrieveModelMixin,
    mixins.CreateModelMixin,
    common_views.BaseGenericViewSet
):
    """
    Class which contain all REST APIs related to Events
    list: Returns all user's events
    all: Returns all available events
    """
    model = models.Event
    serializer_class = serializers.EventSerializer
    queryset = models.Event.objects.prefetch_related('users', 'preferences', 'messages', 'shop_items', 'meals').all()
    user_id = 1     # TODO: Replace with authenticated user id later

    @list_route()
    def all(self, request, *args, **kwargs):
        """
        Returns all available events
        """
        return self.list(request, args, **kwargs)

    def perform_create(self, serializer):
        serializer.save(user_id=self.user_id)

    def get_serializer_context(self):
        context = super(EventView, self).get_serializer_context()
        context.update({
            'is_list': self.action == 'list' or self.action == 'all',
        })
        return context


class EventLocationView(
    mixins.ListModelMixin,
    mixins.RetrieveModelMixin,
    mixins.CreateModelMixin,
    common_views.BaseGenericViewSet
):
    """
    Class which contain all REST APIs related to Event Locations
    all: Returns all  public event locations
    list: Returns all user's private event locations
    """
    model = models.EventLocation
    serializer_class = serializers.EventLocationSerializer
    user_id = 1     # TODO: Replace with authenticated user id later

    def get_queryset(self):
        return models.EventLocation.objects.filter(user_id=self.user_id)

    @list_route()
    def all(self, request, *args, **kwargs):
        """
        Returns all Public event locations
        """
        serializer = self.get_serializer(models.EventLocation.objects.filter(is_public=True), many=True)
        return Response(serializer.data)

    def perform_create(self, serializer):
        serializer.save(user_id=self.user_id)
