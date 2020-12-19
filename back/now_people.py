import datetime
from database import db

def now_congection():
    dt_now = datetime.datetime.now()
    dt_5m_ago = str(dt_now - datetime.timedelta(minutes=5))[:19]
    t = f"select location_id, sum(count) as congection from (select location_id, count(*) from beacon_data group by location_id, time having time between '{dt_5m_ago}' and '{str(dt_now)[:19]}' order by location_id asc) as counts group by location_id"
    id = 'location_id'
    v = 'value'
    now_data = {'congections': []}
    for i in range(77):
        now_data['congections'].append({id: i+1, v: 0})
    for r in db.session.execute(t):
        now_data['congections'][r[id]-1][v] = r['congection']
    return now_data