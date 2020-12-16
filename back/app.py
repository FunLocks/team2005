from flask import Flask, render_template,jsonify,request # 変更
app = Flask(__name__)
app.config["JSON_AS_ASCII"] = False

@app.route('/now_situation', methods=['GET'])
def get():
    response = [
    {
        "time": "2020/12/15 00:00:00",
        "time_people": 0
    },
    {
        "time": "2020/12/15 01:00:00",
        "time_people": 12
    },
    {
        "time": "2020/12/15 02:00:00",
        "time_people": 32
    },
    {
        "time": "2020/12/15 03:00:00",
        "time_people": 14
    },
    {
        "time": "2020/12/15 04:00:00",
        "time_people": 26
    },
    {
        "time": "2020/12/15 05:00:00",
        "time_people": 57
    },
    {
        "time": "2020/12/15 06:00:00",
        "time_people": 22
    },
    {
        "time": "2020/12/15 07:00:00",
        "time_people": 49
    },
    {
        "time": "2020/12/15 08:00:00",
        "time_people": 2
    },
    {
        "time": "2020/12/15 09:00:00",
        "time_people": 0
    },
    {
        "time": "2020/12/15 10:00:00",
        "time_people": 7
    },
    {
        "time": "2020/12/15 11:00:00",
        "time_people": 13
    },
    {
        "time": "2020/12/15 12:00:00",
        "time_people": 22
    },
    {
        "time": "2020/12/15 13:00:00",
        "time_people": 42
    },
    {
        "time": "2020/12/15 14:00:00",
        "time_people": 68
    },
    {
        "time": "2020/12/15 15:00:00",
        "time_people": 7
    }
]


    return jsonify(response)


@app.route('/post', methods=['POST'])
def post():
    data = request.json
    location = data['location_id']
    value = data['time']
    print(f"data['location_id']: {location}")
    print(f"data['time']: {value}")
    return jsonify(data)


if __name__ == '__main__':
    app.run(debug=True)

