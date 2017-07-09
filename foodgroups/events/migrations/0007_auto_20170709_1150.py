# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-07-09 11:50
from __future__ import unicode_literals

import datetime
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('events', '0006_auto_20170708_1546'),
    ]

    operations = [
        migrations.CreateModel(
            name='EventMealVote',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('user_id', models.CharField(help_text='Id of the Meal creator', max_length=20, verbose_name='Meal Creator')),
                ('created_at', models.DateTimeField(default=datetime.datetime.now)),
                ('modified_at', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.AlterModelOptions(
            name='campus',
            options={'verbose_name_plural': 'Campuses'},
        ),
        migrations.AddField(
            model_name='eventmeal',
            name='meal_id',
            field=models.CharField(default=1, help_text='Id of the Global Meal', max_length=20, verbose_name='Meal Id'),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='eventmealvote',
            name='meal',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='votes', to='events.EventMeal'),
        ),
        migrations.AlterUniqueTogether(
            name='eventmealvote',
            unique_together=set([('user_id', 'meal')]),
        ),
    ]
