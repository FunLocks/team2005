#!/usr/bin/python
# -*- coding: utf-8 -*-
import pandas as pd
import json
import datetime

if __name__ == '__main__':
    #train = pd.DataFrame(columns=['location','time','students'])
    train= pd.read_csv('sampledata/congestion_preds.csv')
    #train = pd.concat([train,df],axis=0,ignore_index=True,sort=True)

    for place in ['595','594','593','585','584','583','484','363','koudou','daikougisitu']:
        tmp = train[train['location']==place]
        tmp = train.drop(columns=['location','Unnamed: 0'])

        for index,row in tmp.iterrows():
            d = datetime.datetime.strptime(row['time'],'%Y-%m-%d %H:%M:%S')
            tmp.iloc[index,0] = d.strftime('%H:%M')
            
        json_data = tmp.to_dict(orient='records')
        json_data = {place:json_data}
        filename ='sampledata/predict/location_' + place+'.json'
        with open(filename, 'w') as f:
            json.dump(json_data, f,ensure_ascii=False)       
