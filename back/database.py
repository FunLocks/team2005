from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

class beacon_data(db.Model):
    # テーブル名
    __tablename__ = 'beacon_data'

    # カラム情報
    location_id = db.Column(db.Integer, primary_key=True)
    time = db.Column(db.String(20), nullable=False)

    def __init__(self, location_id, time):
        self.location_id = location_id
        self.time = time

    def to_dict(self):
        return {
            'location_id': self.location_id,
            'time': self.time,
        }