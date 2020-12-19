#!/usr/bin/python
# -*- coding: utf-8 -*-

"""
モデルを作る
"""
import xgboost as xgb
import pickle
import pandas as pd
from sklearn.preprocessing import LabelEncoder
import datetime
import numpy as np
import datetime
import json

class Model:

    def training(self,X_train,Y_train):
        """
        モデルに学習させてpickleにする。
        """

        reg = xgb.XGBRegressor(n_estimators=50)
        reg.fit(X_train, Y_train,) 

        # モデルを保存
        with open('model/model.pickle', mode='wb') as f:  
            pickle.dump(reg, f)       

        return            
    
    def predicting(self,X_test):
        """
        モデル読み込んで予測を吐き出す。
        """
        with open('model/model.pickle', 'rb') as f:
            reg = pickle.load(f)
        preds = reg.predict(X_test)

        result = pd.read_csv('sampledata/test.csv')
        result['students']= pd.Series(np.round(preds))
        result = result.drop(columns=['Unnamed: 0'])

        #最後に整形する
        #マイナスの値や教室が開いてない時間は0に置換して、小数点以下を四捨五入する
        result = self.Formating(result)

        print(result)

        json_data = result.to_dict(orient='records')

        filename = 'sampledata/congestion_preds.json'
        print(filename)
        with open(filename, 'w') as f:
            json.dump(json_data, f, indent=4,ensure_ascii=False)

        result.to_csv('sampledata/congestion_preds.csv')
        return result
    
    def create_features(self,df):
        result = df.copy()
        result = result.drop(columns=['Unnamed: 0'])

        le = LabelEncoder()
        le = le.fit(result['location'])
        result['location'] = le.transform(result['location'])

        DateTime = pd.DataFrame(columns=['year','month','day','hour','minute'])
        for _,row in result.iterrows():
            time = datetime.datetime.strptime(row['time'],'%Y-%m-%d %H:%M:%S')
            DateTime = DateTime.append({'year':int(time.year),'month':int(time.month),'day':int(time.day),'hour':int(time.hour),'minute':int(time.minute)},ignore_index=True,)
        
        result = pd.concat([result,DateTime],axis=1)
        result = result.drop(columns=['time'])
        result = result.astype(int)
        
        return result 
    
    def Formating(self,df):
        for index,row in df.iterrows():
            d = datetime.datetime.strptime(row['time'],'%Y-%m-%d %H:%M:%S')
            if datetime.datetime(2021,12,18,8,0) >= d or datetime.datetime(2021,12,18,22,0) <= d:
                df.iloc[index,2] = 0
            
            if row['students'] <= 0:
                df.iloc[index,2] = 0
        
        return df



if __name__ == '__main__':
    model = Model()

    """
    #データ読み込み
    train = pd.DataFrame(columns=['location','time','students'])
    for i in ['2018_Late','2018_Pre','2019_Late','2019_Pre','2020_Late','2020_Pre']:
        df= pd.read_csv('sampledata/TrainingData/'+i+'.csv')
        train = pd.concat([train,df],axis=0,ignore_index=True,sort=True)
    
    #データきれいきれい 
    train = model.create_features(train)
    print(train)
    print(train.dtypes)

    #学習する
    X_train = train.drop(columns=['students'])
    Y_train = train['students']
    model.training(X_train,Y_train)
    """

    #予測する
    test = pd.read_csv('sampledata/test.csv')
    test = model.create_features(test)
    model.predicting(test)




