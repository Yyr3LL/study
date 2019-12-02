# Generated by Django 2.2.7 on 2019-12-01 18:34

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Bank',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.TextField(max_length=255)),
                ('money_count', models.IntegerField()),
            ],
            options={
                'verbose_name': 'bank',
                'verbose_name_plural': 'banks',
            },
        ),
        migrations.CreateModel(
            name='Member',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('full_name', models.TextField(max_length=255)),
                ('money_count', models.IntegerField()),
                ('bank', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='members', to='app.Bank')),
            ],
            options={
                'verbose_name': 'family member',
                'verbose_name_plural': 'family members',
            },
        ),
        migrations.CreateModel(
            name='Transaction',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('value', models.IntegerField()),
                ('date', models.DateTimeField(auto_now_add=True)),
                ('member', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='transactions', to='app.Member')),
            ],
            options={
                'verbose_name': 'transaction',
                'verbose_name_plural': 'transactions',
            },
        ),
    ]
