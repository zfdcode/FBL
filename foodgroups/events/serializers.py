from rest_framework import serializers
from events import models
from users import (
    serializers as user_serializers
)


class CampusSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Campus
        fields = ('id', 'name', 'description')
        read_only_fields = ('id', 'name', 'description')


class EventLocationSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.EventLocation
        fields = ('id', 'name', 'description', 'is_public', 'created_at', 'campus')
        read_only_fields = ('id', 'created_at', 'modified_at', 'is_public')

    def to_representation(self, instance):
        data = super(EventLocationSerializer, self).to_representation(instance)
        if instance.campus:
            data['campus'] = CampusSerializer(instance=instance.campus).data
        return data

    def save(self, **kwargs):
        self._validated_data.update({
            'user_id': kwargs.pop('user_id')
        })
        return super(EventLocationSerializer, self).save(**kwargs)


class EventShoppingItemSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.EventShoppingItem
        fields = ('id', 'name', 'created_at', 'event')
        read_only_fields = ('id', 'created_at', 'modified_at')

    def to_representation(self, instance):
        data = super(EventShoppingItemSerializer, self).to_representation(instance)
        data['creator'] = user_serializers.UserSerializer(instance=instance.user_id).data
        return data


class EventMealSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.EventShoppingItem
        fields = ('id', 'name', 'created_at', 'event')
        read_only_fields = ('id', 'created_at', 'modified_at')

    def to_representation(self, instance):
        data = super(EventMealSerializer, self).to_representation(instance)
        data['creator'] = user_serializers.UserSerializer(instance=instance.user_id).data
        return data


class EventMessageSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.EventMessage
        fields = ('id', 'text', 'user_id', 'event')
        read_only_fields = ('id', 'created_at', 'modified_at')

    def to_representation(self, instance):
        data = super(EventMessageSerializer, self).to_representation(instance)
        data['creator'] = user_serializers.UserSerializer(instance=instance.user_id).data
        return data


class EventPreferenceSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.EventPreference

    def to_representation(self, instance):
        return user_serializers.FoodPreferenceSerializer(instance=instance.food_preference).data


class EventUserSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.EventUser
        fields = ('event', 'user_id')

    def to_representation(self, instance):
        """
        :param instance: EventUser instance
        :return: UserSerializer data
        """
        return user_serializers.UserSerializer(instance=instance.user_id).data


class EventSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Event
        fields = ('id', 'title', 'description', 'start_at', 'end_at', 'created_at', 'capacity', 'user_id', 'location')
        read_only_fields = ('id', 'created_at', 'user_id')

    def to_representation(self, instance):
        data = super(EventSerializer, self).to_representation(instance)
        data['creator'] = user_serializers.UserSerializer(instance=instance.user_id).data

        if self.context.get('is_list', False):
            data['num_members'] = instance.users.count()
            data['members'] = []
            data['shoppingitems'] = []
            data['meals'] = []
            data['messages'] = []
        else:
            data['members'] = user_serializers.UserSerializer(
                instance=instance.users.all().values_list('user_id', flat=True),
                many=True
            ).data
            data['num_members'] = len(data['members'])
            data['shoppingitems'] = EventShoppingItemSerializer(instance=instance.shop_items.all(), many=True).data
            data['meals'] = EventShoppingItemSerializer(instance=instance.meals.all(), many=True).data
            data['messages'] = EventShoppingItemSerializer(instance=instance.shop_items.all(), many=True).data

        data['preferences'] = EventPreferenceSerializer(
            instance=instance.preferences.all(),
            many=True
        ).data
        data['location'] = EventLocationSerializer(instance=instance.location).data
        return data

    def save(self, **kwargs):
        self._validated_data.update({
            'user_id': kwargs.pop('user_id')
        })
        return super(EventSerializer, self).save(**kwargs)
