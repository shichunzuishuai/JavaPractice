package service;


import dao.MusicDao;
import entity.Music;

import java.util.List;

public class MusicService {
    MusicDao musicDao = new MusicDao();
    //查询全部歌单
    public List<Music> findMusic(){
        return musicDao.findMusic();
    }

    //根据id查找音乐
    public  Music findMusicById(int id){
        return musicDao.findMusicById(id);
    }

    // 根据关键字来查找歌曲
    public List<Music> ifMusic(String str){
        return musicDao.ifMusic(str);
    }

    // 上传音乐
    public int insert(String title, String singer, String time, String url, int userid) {
        int ret = musicDao.insert(title, singer, time, url, userid);
        if(ret == 1){
            return 1;
        }
        return 0;
    }

    // //删除音乐,根据音乐的id进行删除
    public  int deleteMusicById(int id) {
        int ret = musicDao.deleteMusicById(id);
        if(ret == 1){
            if(musicDao.findLoveMusicOnDel(id)){
                   int res = musicDao.removeLoveMusicOnDel(id);
                   if(res == 1){
                       return 1;
                   }
               }
            return 1;
        }
        return 0;
    }


    //移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢，所以需要传入当前用户的id
    public  int removeLoveMusic(int userId,int musicId) {
        return musicDao.removeLoveMusic(userId,musicId);
    }

    //添加喜欢的音乐的时候，需要先判断该音乐是否存在，也就是说，
    // 该用户是否之前添加过这个音乐为喜欢。
    public  boolean findMusicByMusicId(int user_id,int musicID) {
        return findMusicByMusicId(user_id,musicID);
    }

    //添加音乐到“喜欢”列表中
    public  boolean insertLoveMusic(int userId,int musicId) {
        boolean fbd = musicDao.findMusicByMusicId(userId,musicId);
        int ret = 0;
        if(fbd == false){
            ret = musicDao.insertLoveMusic(userId,musicId);
            if(ret == 1){
                return true;
            }
        }
        return false;
    }

    //查询该用户喜欢的全部歌单
    public List<Music> findLoveMusic(int user_id){
        return musicDao.findLoveMusic(user_id);
    }

    //根据关键字查询喜欢的歌单
    public  List<Music> ifMusicLove(String str,int user_id){
        return musicDao.ifMusicLove(str,user_id);
    }



}































