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
        fav: DataFrame = pd.DataFrame(columns=['congection'])
        
        for i in range(1,25):
            fav.loc[i] = (random.randint(random_min,random_max))

        return fav


if __name__ == '__main__':
    generator = GenerateData()
    for i in range(1,78):
        sample_data = generator.favorite(1,25)
        json_data = sample_data.to_dict()

        filename = "sampledata/favorite/location_id_" + str(i) + ".json"
        print(filename)
        with open(filename, 'w') as f:
            json.dump(json_data, f, ensure_ascii=False)
