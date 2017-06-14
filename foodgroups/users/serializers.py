from rest_framework import serializers
from users.models import FoodPreference, UserFoodPreference


class FoodPreferenceSerializer(serializers.ModelSerializer):

    class Meta:
        model = FoodPreference
        fields = ('slug', 'name',)


class UserFoodPreferenceSerializer(serializers.Serializer):
    preferences = serializers.ListField()

    def is_valid(self, raise_exception=False):
        super(UserFoodPreferenceSerializer, self).is_valid()

    def save(self, **kwargs):
        user_id = kwargs.get('user_id')
        for preference in self.data.get('preferences', ()):
            if FoodPreference.objects.filter(slug=preference['slug']).exists():
                UserFoodPreference.objects.get_or_create(user_id=user_id, preference_id=preference['slug'])
