package ru.eyelog.moxymvppattern;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import ru.eyelog.moxymvppattern.UtilsDB.AppDBConnector;
import ru.eyelog.moxymvppattern.UtilsDB.AppDatabase;
import ru.eyelog.moxymvppattern.UtilsDB.Data;
import ru.eyelog.moxymvppattern.UtilsDB.DataDao;

@InjectViewState
public class FragmentPresenter extends MvpPresenter<FragmentView> {

    Data data;

    AppDatabase appDatabase;
    DataDao dataDao;

    public FragmentPresenter() {
        appDatabase = AppDBConnector.getInstance().getDatabase();
        dataDao = appDatabase.dataDao();
    }

    public void createData(String string){
        data = new Data(string);
        dataDao.insert(data);
        getViewState().setData(data.getData());
    }

    public void updateData(){
        List<Data> datas = dataDao.getAll();
        Data data = datas.get(datas.size()-1);
        getViewState().setData(data.getData());
    }

    public void deleteData(){
        List<Data> datas = dataDao.getAll();
        Data data = datas.get(datas.size()-1);
        dataDao.delete(data);
        data = new Data("Пусто");
        getViewState().setData(data.getData());
    }
}
