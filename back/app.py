from flask import Flask, render_template,jsonify,request # 変更
from database import db, beacon_data
from now_people import now_congection
app = Flask(__name__)
app.config["JSON_AS_ASCII"] = False
app.config.from_object('config.Config')
db.init_app(app)

@app.route('/now_situation', methods=['GET'])
def get():
    response = now_congection()
    return jsonify(response)


@app.route('/post', methods=['POST'])
def post():
    data = request.json
    location = data['location_id']
    value = data['time']
    print(f"data['location_id']: {location}")
    print(f"data['time']: {value}")
    db.session.add(beacon_data(location_id=location, time=value))
    db.session.commit()
    return jsonify(data)


if __name__ == '__main__':
    app.run(debug=True)

