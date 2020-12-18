#!/usr/bin/python
# -*- coding: utf-8 -*-

import model


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
    #X_train = train.drop(columns=['students'])
    #Y_train = train['students']
    #model.training(X_train,Y_train)

    #予測する
    test = pd.read_csv('sampledata/test.csv')
    test = model.create_features(test)
    model.predicting(test)
