import random
from rest_framework import serializers
from users.models import FoodPreference, UserFoodPreference


class UserSerializer(serializers.Serializer):
    fields = ('id', 'name')
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

    def to_representation(self, instance):
        user_id = str(instance)
        data = {
            'id': user_id,
            'name': self.user_names.get(user_id, 'Sam')
        }
        return data


class FoodPreferenceSerializer(serializers.ModelSerializer):

    class Meta:
        model = FoodPreference
        fields = ('id', 'slug', 'name')


class UserFoodPreferenceSerializer(serializers.Serializer):
    preferences = serializers.ListField()

    def is_valid(self, raise_exception=False):
        super(UserFoodPreferenceSerializer, self).is_valid()

    def save(self, **kwargs):
        user_id = kwargs.get('user_id')
        for preference in self.data.get('preferences', ()):
            if FoodPreference.objects.filter(slug=preference['slug']).exists():
                UserFoodPreference.objects.get_or_create(user_id=user_id, preference__slug=preference['slug'])
