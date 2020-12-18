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
        #preds.to_csv('sampledata/congestion_preds.csv')

        print(preds)

        return
    
    def create_features(self,df):
        result = df.copy()
        result = result.drop(columns=['Unnamed: 0'])

        le = LabelEncoder()
        le = le.fit(result['location'])
        result['location'] = le.transform(result['location'])

        for _,row in result.iterrows():
            time = datetime.datetime.strptime(row['time'],'%Y-%m-%d %H:%M:%S')
            result['year'] = time.year
            result['month'] = time.month
            result['date'] = time.day
            result['hour'] = time.hour
            result['minute'] = time.minute
        
        result = result.drop(columns=['time'])
        return result




if __name__ == '__main__':
    model = Model()

    #データ読み込み
    train = pd.DataFrame(columns=['location','time','students'])
    for i in ['2018_Late','2018_Pre','2019_Late','2019_Pre','2020_Late','2020_Pre']:
        df= pd.read_csv('sampledata/TrainingData/'+i+'.csv')
        train = pd.concat([train,df],axis=0,ignore_index=True,sort=True)
    

    #データきれいきれい 
    train = model.create_features(train)

    print(train)

    #学習する
    X_train = train.drop(columns=['students'])
    Y_train = train['students']
    model.training(X_train,Y_train)

    #予測する
    test = pd.read_csv('sampledata/test.csv')
    test = model.create_features(test)
    model.predicting(test)


