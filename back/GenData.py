#!/usr/bin/python
# -*- coding: utf-8 -*-

"""
サンプルのデータを生成するためのスクリプト
"""

import pandas as pd
import datetime
import random
import json


class GenerateData:
    def __init__(self):
        return

    def favorite(self, random_min: int, random_max: int):
        for i in range(1,78):
            fav: DataFrame = pd.DataFrame(columns=['time','congection'])

            for j in range(1,25):
                fav = fav.append({'time':j,'congection':random.randint(random_min,random_max)}, ignore_index=True)
            
            print(fav)
            json_data = fav.to_dict()

            filename = "sampledata/favorite/location_id_" + str(i) + ".json"
            print(filename)
            with open(filename, 'w') as f:
                json.dump(json_data, f, indent=4,ensure_ascii=False)

        return 
    
    def predict(self,random_min: int,random_max: int):
        floor_1 = [1,2,3,4,5,60,61,62]
        floor_2 = [6,7,8,9,10,63,64,65]
        floor_3 = [11,12,13,14,15,16,17,18,19,20,21,22,23,24,66,67,68,69,70]
        floor_4 = [25,26,27,28,29,30,31,32,33,34,35,36,71,72,73,74]
        floor_5 = [37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59]
        time = [-1,0,1,2,3,4,5,6,7,8,9,10,11,12]

        def make_data(floor: str,floorlist: list):
            df_1 = pd.DataFrame(columns=['location_id','time','congection'])
            for i in floorlist:
                for j in (time):
                    df_1 = df_1.append({'location_id':i, 'time':j,'congection': random.randint(random_min,random_max)}, ignore_index=True)

            print(df_1)
            json_data = fav.to_dict(orient='records')

            filename = "sampledata/predict/" + floor + ".json"
            print(filename)
            with open(filename, 'w') as f:
                json.dump(json_data, f, indent=4,ensure_ascii=False)
            
            return
            
        make_data("floor_1",floor_1)
        make_data("floor_2",floor_2)
        make_data("floor_3",floor_3)
        make_data("floor_4",floor_4)
        make_data("floor_5",floor_5)

        return
    
    def now_situation(self, random_min: int, random_max: int):
        df_1 = pd.DataFrame(columns=['location_id','congection'])
        for i in range(77):
            df_1 = df_1.append({'location_id':i+1, 'congection':random.randint(random_min,random_max)}, ignore_index=True)
        
        print(df_1)
        json_data = df_1.to_dict()

        filename = "sampledata/CongectionNow.json"
        print(filename)
        with open(filename, 'w') as f:
            json.dump(json_data, f, indent=4,ensure_ascii=False)




    


if __name__ == '__main__':
    generator = GenerateData()
    generator.now_situation(1,20)
