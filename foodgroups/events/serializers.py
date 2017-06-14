from rest_framework import serializers
from events.models import Event
from users import (
    models as user_models,
    serializers as user_serializers
)


class EventSerializer(serializers.ModelSerializer):

    class Meta:
        model = Event
        fields = ('title', 'occur_at', 'food_preferences')

    def to_representation(self, instance):
        data = super(EventSerializer, self).to_representation(instance)
        data['created_by'] = "Sahil"
        data['food_preferences'] = user_serializers.FoodPreferenceSerializer(
            instance=user_models.FoodPreference.objects.all(),
            many=True
        ).data
        return data
