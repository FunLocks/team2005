from flask import Flask, render_template,jsonify,request # 変更
from database import db, beacon_data
from now_people import now_congection
#from favorite_predict import favorite_predict
import json

app = Flask(__name__)
app.config["JSON_AS_ASCII"] = False
app.config.from_object('config.Config')
db.init_app(app)

@app.route('/now_situation', methods=['GET'])
def get_now():
    json_open = open('sampledata/CongectionNow.json', 'r')
    json_load = json.load(json_open)
    return jsonify(json_load)

@app.route('/favorite_predict/<location_id>', methods=['GET'])
def get_fav(location_id):
    #response = favorite_predict(location_id)
    #return jsonify(response)

    json_open = open('sampledata/favorite/location_id_'+location_id+'.json', 'r')
    json_load = json.load(json_open)
    return jsonify(json_load)

@app.route('/predict/<floor>', methods=['GET'])
def get_predict(floor):
    json_open = open('sampledata/predict/floor_'+floor+'.json', 'r')
    json_load = json.load(json_open)
    return jsonify(json_load)

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

