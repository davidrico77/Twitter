package fdi.myproyect.twitter.servicioAplicacion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdi.myproyect.twitter.entidades.TweetEntity;

import fdi.myproyect.twitter.repositorios.TwitterRepositorio;

@Service
@Transactional
public class TwitterSA {
	
	TwitterRepositorio repositorio;
	
	@Autowired
	public TwitterSA(TwitterRepositorio repositorio)
	{
		this.repositorio = repositorio;
	}
	
	public void addTweet(TweetEntity tweet){
	
		repositorio.addTweet(tweet);
	}
	
	 public  List<TweetEntity> getAllTweets()
	 {
		 return repositorio.getAllTweets();
	 }
	
	 public List<TweetEntity> getAllTweetsByUser(int id){
		return this.repositorio.getAllTweetsByUser(id);
	 }

}
