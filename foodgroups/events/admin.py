from django.contrib import admin
from events import models


class EventAdmin(admin.ModelAdmin):
    list_display = ('title', 'created_at', 'occur_at', 'created_by_id')


# Register your models here.
admin.site.register(models.Event, EventAdmin)
