# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-06-25 09:15
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='FoodPreference',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('slug', models.SlugField()),
                ('name', models.CharField(max_length=50)),
            ],
        ),
        migrations.CreateModel(
            name='UserFoodPreference',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('user_id', models.CharField(max_length=20)),
                ('preference', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='users', to='users.FoodPreference')),
            ],
        ),
        migrations.AlterUniqueTogether(
            name='userfoodpreference',
            unique_together=set([('user_id', 'preference')]),
        ),
    ]
