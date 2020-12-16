import datetime
from database import *

def now_congection():
    dt_now = datetime.datetime.now()
    dt_5m_ago = str(dt_now - datetime.timedelta(minutes=5))[:19]
    t = f"select location_id, sum(count) as congection from (select location_id, count(*) from beacon_data group by location_id, time having time between '{dt_5m_ago}' and '{str(dt_now)[:19]}' order by location_id asc) as counts group by location_id"
    congection_dict = {}
    for r in db.session.execute(t):
        congection_dict[r['location_id']] = r['congection']
    return congection_dict