from django.core.exceptions import ObjectDoesNotExist
from rest_framework import (
    mixins,
    status,
)
from rest_framework.decorators import list_route, detail_route
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
    mixins.UpdateModelMixin,
    mixins.DestroyModelMixin,
    common_views.AuthBaseGenericViewSet
):
    """
    Class which contain all REST APIs related to Events
    list: Returns all user's events
    all: Returns all available events
    """
    model = models.Event
    serializer_class = serializers.EventSerializer
    users_serializer_class = serializers.EventUserSerializer
    messages_serializer_class = serializers.EventMessageSerializer
    meals_serializer_class = serializers.EventMealSerializer
    shoppingitems_serializer_class = serializers.EventShoppingItemSerializer
    queryset = models.Event.objects.prefetch_related('users', 'preferences', 'messages', 'shop_items', 'meals').all()

    @property
    def user_id(self):
        return self.request.user.user_id

    @list_route(authentication_classes=[], permission_classes=[])
    def all(self, request, *args, **kwargs):
        """
        Returns all available events
        """
        return self.list(request, args, **kwargs)

    @detail_route(methods=['post'])
    def join(self, request, *args, **kwargs):
        """
        Add a user to the event
        Returns new user of the Event
        """
        event_obj = self.get_object()
        user_id = self.user_id
        try:
            event_user = event_obj.users.get(user_id=user_id)
        except ObjectDoesNotExist:
            # Create a Event user object on POST
            users_serializer = self.users_serializer_class(data={
                'event': event_obj.id,
                'user_id': user_id
            })

            users_serializer.is_valid(raise_exception=True)
            event_user = users_serializer.save()
        return Response(
            self.users_serializer_class(instance=event_user).data,
            status=status.HTTP_201_CREATED
        )

    @detail_route(methods=['post'])
    def leave(self, request, *args, **kwargs):
        """
        Delete a user from the event
        Returns code 204
        """
        event_obj = self.get_object()
        user_id = self.user_id
        models.EventUser.objects.filter(event=event_obj, user_id=user_id).delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

    @detail_route(methods=['get', 'post'])
    def messages(self, request, *args, **kwargs):
        """
        GET: List all messages of a group
        POST: Create new message for a group
        """
        event_obj = self.get_object()
        if request.method.lower() == "get":
            return Response(
                self.messages_serializer_class(instance=event_obj.messages.all(), many=True).data
            )
        else:
            data = request.data.copy()
            data['user_id'] = self.user_id
            data['event'] = event_obj.id
            messages_serializer = self.messages_serializer_class(data=data)
            messages_serializer.is_valid(raise_exception=True)
            event_message = messages_serializer.save()
            return Response(
                self.messages_serializer_class(instance=event_message).data,
                status=status.HTTP_201_CREATED
            )

    @detail_route(methods=['get', 'post'])
    def meals(self, request, *args, **kwargs):
        """
        GET: List all meals of a group
        POST: Create new meal for a group
        """
        event_obj = self.get_object()
        if request.method.lower() == "get":
            return Response(
                self.meals_serializer_class(instance=event_obj.meals.all(), many=True).data
            )
        else:
            data = request.data.copy()
            data['user_id'] = self.user_id
            data['event'] = event_obj.id
            meals_serializer = self.meals_serializer_class(data=data)
            meals_serializer.is_valid(raise_exception=True)
            event_meal = meals_serializer.save()
            return Response(
                self.meals_serializer_class(instance=event_meal).data,
                status=status.HTTP_201_CREATED
            )

    @detail_route(methods=['get', 'post'])
    def shoppingitems(self, request, *args, **kwargs):
        """
        GET: List all Shopping items of a group
        POST: Create new Shopping Item for a group
        """
        event_obj = self.get_object()
        if request.method.lower() == "get":
            return Response(
                self.shoppingitems_serializer_class(instance=event_obj.shop_items.all(), many=True).data
            )
        else:
            data = request.data.copy()
            data['user_id'] = self.user_id
            data['event'] = event_obj.id
            shoppingitems_serializer = self.shoppingitems_serializer_class(data=data)
            shoppingitems_serializer.is_valid(raise_exception=True)
            event_shoppingitem = shoppingitems_serializer.save()
            return Response(
                self.shoppingitems_serializer_class(instance=event_shoppingitem).data,
                status=status.HTTP_201_CREATED
            )

    def perform_create(self, serializer):
        serializer.save(user_id=self.user_id)

    def perform_update(self, serializer):
        serializer.save(user_id=self.user_id)

    def get_serializer_context(self):
        context = super(EventView, self).get_serializer_context()
        context.update({
            'is_list': self.action == 'list' or self.action == 'all',
        })
        return context


class EventMessageView(
    mixins.RetrieveModelMixin,
    mixins.DestroyModelMixin,
    common_views.AuthBaseGenericViewSet
):
    """
    Class for API to Retrieve and delete an event message
    """
    model = models.EventMessage
    serializer_class = serializers.EventMessageSerializer
    queryset = models.EventMessage.objects.all()


class EventShoppingItemView(
    mixins.RetrieveModelMixin,
    mixins.DestroyModelMixin,
    common_views.AuthBaseGenericViewSet
):
    """
    Class for API to Retrieve and delete an event shopping item
    """
    model = models.EventShoppingItem
    serializer_class = serializers.EventShoppingItemSerializer
    bring_serializer_class = serializers.EventShoppingItemBringSerializer
    queryset = models.EventShoppingItem.objects.all()

    @property
    def user_id(self):
        return self.request.user.user_id

    @detail_route(methods=['post'])
    def bring(self, request, *args, **kwargs):
        """
        User brings ShoppingItem 
        Returns ShoppingItem Object
        """
        item_obj = self.get_object()
        save_data = {
            'user_id': self.user_id,
            'item_obj': item_obj
        }
        bring_serializer = self.bring_serializer_class(data=self.request.data)
        bring_serializer.is_valid(raise_exception=True)
        bring_serializer.save(**save_data)

        return Response(
            self.serializer_class(instance=item_obj).data,
        )


class EventMealView(
    mixins.RetrieveModelMixin,
    mixins.DestroyModelMixin,
    common_views.AuthBaseGenericViewSet
):
    """
    Class for API to Retrieve and delete an event meal
    """
    model = models.EventMeal
    serializer_class = serializers.EventMealSerializer
    vote_serializer_class = serializers.EventMealVoteSerializer
    queryset = models.EventMeal.objects.all()

    @property
    def user_id(self):
        return self.request.user.user_id

    @detail_route(methods=['post'])
    def vote(self, request, *args, **kwargs):
        """
        User Vote/DeVote on a meal
        Returns Meal Object
        """
        meal_obj = self.get_object()
        save_data = {
            'user_id': self.user_id,
            'meal_obj': meal_obj
        }
        vote_serializer = self.vote_serializer_class(data=self.request.data)
        vote_serializer.is_valid(raise_exception=True)
        vote_serializer.save(**save_data)

        return Response(
            self.serializer_class(instance=meal_obj).data,
        )


class EventLocationView(
    mixins.ListModelMixin,
    mixins.RetrieveModelMixin,
    mixins.CreateModelMixin,
    common_views.AuthBaseGenericViewSet
):
    """
    Class which contain all REST APIs related to Event Locations
    all: Returns all  public event locations
    list: Returns all user's private event locations
    """
    model = models.EventLocation
    serializer_class = serializers.EventLocationSerializer

    @property
    def user_id(self):
        return self.request.user.user_id

    def get_queryset(self):
        return models.EventLocation.objects.filter(user_id=self.user_id)

    @list_route(authentication_classes=[], permission_classes=[])
    def all(self, request, *args, **kwargs):
        """
        Returns all Public event locations
        """
        serializer = self.get_serializer(models.EventLocation.objects.filter(is_public=True), many=True)
        return Response(serializer.data)

    def perform_create(self, serializer):
        serializer.save(user_id=self.user_id)


class CampusView(
    mixins.ListModelMixin,
    mixins.RetrieveModelMixin,
    common_views.BaseGenericViewSet
):
    """
    Class for Campus APIs 
    """
    model = models.Campus
    serializer_class = serializers.CampusSerializer
    queryset = models.Campus.objects.all()
