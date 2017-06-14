# -*- coding: utf-8 -*-
# Generated by Django 1.11.2 on 2017-06-14 16:59
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='userfoodpreference',
            name='preference',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='users', to='users.FoodPreference'),
        ),
        migrations.AlterUniqueTogether(
            name='userfoodpreference',
            unique_together=set([('user_id', 'preference')]),
        ),
    ]
