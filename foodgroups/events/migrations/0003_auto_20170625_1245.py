# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-06-25 12:45
from __future__ import unicode_literals

import datetime
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('events', '0002_auto_20170625_0949'),
    ]

    operations = [
        migrations.CreateModel(
            name='EventMeal',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('user_id', models.CharField(help_text='Id of the Meal creator', max_length=20, verbose_name='Meal Creator')),
                ('created_at', models.DateTimeField(default=datetime.datetime.now)),
                ('modified_at', models.DateTimeField(auto_now=True)),
                ('name', models.CharField(max_length=100)),
            ],
        ),
        migrations.AlterModelOptions(
            name='eventuser',
            options={'verbose_name': 'Event Member'},
        ),
        migrations.AlterField(
            model_name='event',
            name='user_id',
            field=models.CharField(help_text='Id of the Event creator', max_length=20, verbose_name='Event Creator'),
        ),
        migrations.AlterField(
            model_name='eventmessage',
            name='event',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='messages', to='events.Event'),
        ),
        migrations.AlterField(
            model_name='eventmessage',
            name='user_id',
            field=models.CharField(help_text='Id of the Message creator', max_length=20, verbose_name='Message Creator'),
        ),
        migrations.AlterField(
            model_name='eventpreference',
            name='event',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='preferences', to='events.Event'),
        ),
        migrations.AlterField(
            model_name='eventshoppingitem',
            name='event',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='shop_items', to='events.Event'),
        ),
        migrations.AlterField(
            model_name='eventshoppingitem',
            name='user_id',
            field=models.CharField(help_text='Id of the Shopping item creator', max_length=20, verbose_name='Item Creator'),
        ),
        migrations.AlterField(
            model_name='eventuser',
            name='event',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='users', to='events.Event'),
        ),
        migrations.AlterField(
            model_name='eventuser',
            name='user_id',
            field=models.CharField(help_text='Id of the Event participant', max_length=20, verbose_name='Event Member'),
        ),
        migrations.AddField(
            model_name='eventmeal',
            name='event',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='meals', to='events.Event'),
        ),
    ]
