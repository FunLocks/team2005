#!/usr/bin/python
# -*- coding: utf-8 -*-
import datetime
from database import db

def favorite_predict(location_id: str):
    t = 'select location_id,time from beacon_data'
    for r in db.session.execute(t):
        print (r['location_id'])
        print (r['time'])
    
    return {"maru":"mayo"}

if __name__ == '__main__':
    favorite_predict()