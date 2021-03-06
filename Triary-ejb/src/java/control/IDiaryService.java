/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Time;
import java.util.List;
import model.Diary;
import model.Users;

/**
 *
 * @author kate
 */
public interface IDiaryService {
    
    public String selectTrainingType(Integer index);
    
    public String selectMuscleGroup(Integer index);
    
    public String selectTask(Integer index);
    
    public Long selectWeight(Integer index);
    
    public Integer selectRepeats(Integer index);
    
    public void addFilings(Diary diary, String filings);
    
    public void addRecord(Users usr,String training_type, String muscle_gr,  String tasks,  String fillings);
    
    public List<Diary> getAll(Users user);
    
}