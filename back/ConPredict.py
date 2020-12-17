#!/usr/bin/python
# -*- coding: utf-8 -*-

#!/usr/bin/python
# -*- coding: utf-8 -*-
import datetime
from database import db

def predict(location_id: str):
    t = f"select location_id,time from beacon_data"
    for r in db.session.execute(t):
    
    return {"maru":"mayo"}

if __name__ == '__main__':
    predict()