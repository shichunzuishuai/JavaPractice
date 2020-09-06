package dao;

import entity.Music;
import util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//有关music的操作
public class MusicDao {
    //查询全部歌单
    public List<Music> findMusic(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> list = new ArrayList<>();
        try {
            String sql = "select * from music";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
        return list;
    }



    //根据id查找音乐
    public  Music findMusicById(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Music music = null;
        try {
            String sql ="select * from music where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                 music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtils.close(connection,ps,rs);
        }
        return music;
    }


    //根据关键字来查找歌曲
    public List<Music> ifMusic(String str){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        List<Music> list = new ArrayList<>();
        try {
            String sql = " select * from music where title like '%" + str + "%'";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
        return list;
    }

    //上传音乐
    //1.上传文件本身给服务器(这需要在前端进行处理)
    //2.将音乐信息插入到数据库中,现在就在执行这一步
    public int insert(String title, String singer, String time, String url, int userid) {
        Connection connection = null;
        PreparedStatement ps = null;
        int ret = 0;
        try {
            String sql = "insert into music(title, singer, time, url, userid) values (?,?,?,?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,singer);
            ps.setString(3,time);
            ps.setString(4,url);
            ps.setInt(5,userid);
            ret = ps.executeUpdate();
//            if(ret == 1){
//                return 1;
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        //return 0;
        return ret;
    }
    //删除音乐,根据音乐的id进行删除
    //删除音乐之前,要先在喜欢的歌单里进行的查看,看是否在喜欢的歌单里,如果存在,就要一并删除
    public  int deleteMusicById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            String sql = "delete from music where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            if(ret == 1){
                //删除音乐库的歌应该也把喜欢的歌单里这首歌也删掉
                //此处先不用判定,在MusicService层里会进行判定
//               if(findLoveMusicOnDel(id)){
//                   int res = removeLoveMusicOnDel(id);
//                   if(res == 1){
//                       return 1;
//                   }
//               }
               return 1;//表示这首歌没有被添加到喜欢的音乐列表中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return 0;
    }

    //删除一首歌时也要删除喜欢的音乐中的这首歌
    public int removeLoveMusicOnDel(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            String sql = "delete from lovemusic where music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            if(ret == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return 0;
    }


    //删除歌曲，需要先看该歌曲之前是否被添加到了，喜欢的音乐列表当中
    public  boolean findLoveMusicOnDel(int id) {
        Connection connection = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            String sql = "select * from lovemusic where music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
        return false;
    }

    //移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢，所以需要传入当前用户的id
    public  int removeLoveMusic(int userId,int musicId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int ret = 0;
        try {
            String sql = "delete from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,musicId);
             ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return ret;
    }

    //添加音乐到喜欢列表
    public  int  insertLoveMusic(int userId,int musicId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int ret = 0;
        try {
            String sql = "insert into lovemusic(user_id, music_id) VALUES (?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,musicId);
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return ret;
    }


    //添加喜欢的音乐的时候，需要先判断该音乐是否存在，也就是说，
    // 该用户是否之前添加过这个音乐为喜欢。
    public  boolean findMusicByMusicId(int user_id,int musicID) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,musicID);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return false;
    }


    //查询该用户喜欢的全部歌单,只查询一张lovemusic是做不到的。需要联表查询
    public List<Music> findLoveMusic(int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> list = new ArrayList<>();
        try {
            String sql = "select m.id as music_id,title,singer,time,url,userid " +
                    "from lovemusic lm,music m where lm.music_id=m.id and user_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while (rs.next()){
                Music music = new Music();
                //注意哟啊查到的列明要相对应
                music.setId(rs.getInt("music_id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return list;
    }

    //根据关键字查询喜欢的歌单
    public  List<Music> ifMusicLove(String str,int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        List<Music> list = new ArrayList<>();
        try {
            String sql = "select m.id as music_id,title,singer,time,url,userid from lovemusic lm,music m where lm.music_id=m.id and user_id=? and title like '%"+str+"%'";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            if (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("music_id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
        return list;
    }



    public static void main(String[] args) {
//        List<Music> list = ifMusic("方");
//        System.out.println(list);
//         Music music = findMusicById(1);
//        System.out.println(music);
 //       insert("铁锤妹妹","龙世春","2020-07-23","music\\铁锤妹妹",1);
  //      System.out.println(deleteMusicById(5));
 //       System.out.println(removeLoveMusic(1,2));
  //      System.out.println(insertLoveMusic(1, 2));

//        List<Music> list = findLoveMusic(1);
//        System.out.println(list);
//        List<Music> list = ifMusicLove("南",1);
//        System.out.println(list);

//        MusicService  musicService = new MusicService();
//        int ret = musicService.deleteMusicById(7);
//        System.out.println(ret);

    }
}
