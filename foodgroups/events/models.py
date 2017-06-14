from django.db import models

from datetime import datetime
# Create your models here.


class Event(models.Model):
    title = models.CharField(max_length=100, blank=True)
    created_at = models.DateTimeField(default=datetime.now)
    occur_at = models.DateTimeField(default=datetime.now)
    created_by_id = models.CharField(max_length=20)
    food_preferences = models.TextField(blank=True)


class EventUser(models.Model):
    event = models.ForeignKey(Event)
    user_id = models.CharField(max_length=20)
    created_at = models.DateTimeField(default=datetime.now)

    class Meta:
        unique_together = ('event', 'user_id')
