package org.suhee.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suhee.demo.dao.PostDao;
import org.suhee.demo.entity.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostDao postDao;
	
	/**
	 * <pre>
	 * 글을 작성할 페이지를 반환한다.
	 *  
	 * history
	 * 2015. 7. 22. by 조수희
	 * 초기 개발
	 * </pre>
	 *
	 * @since 2015. 7. 22.오후 5:30:22
	 * @param post
	 * @return
	 */
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String form(Post post) {
		return "form";
	}
	
	/**
	 * <pre>
	 * 글 정보를 저장한다.
	 *  
	 * history
	 * 2015. 7. 23. by 조수희
	 * 초기 개발
	 * </pre>
	 *
	 * @since 2015. 7. 23.오후 2:52:23
	 * @param post
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST) 
	public String write(@Valid Post post, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		post.setRegDate(new Date());
		return "redirect:/post/" + postDao.save(post).getId();
	}
	
	/**
	 * <pre>
	 * 리스트를 반환한다.
	 *  
	 * history
	 * 2015. 7. 22. by 조수희
	 * 초기 개발
	 * </pre>
	 *
	 * @since 2015. 7. 22.오후 5:30:34
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		List<Post> postList = postDao.findAll();
		model.addAttribute("postList", postList);
		return "blog";
	}
	
	/**
	 * <pre> 
	 * 글 정보를 반환한다.
	 * 
	 * history
	 * 2015. 7. 22. by 조수희
	 * 초기 개발
	 * </pre>
	 *
	 * @since 2015. 7. 22.오후 5:30:41
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public String view(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id);
		model.addAttribute("post", post);
		return "post";
	}

}
