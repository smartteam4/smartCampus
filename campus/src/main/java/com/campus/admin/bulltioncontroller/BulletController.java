package com.campus.admin.bulltioncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.campus.entity.Bulletin;
import com.campus.repository.BulletinRepository;

@RestController
@RequestMapping("/admin")
public class bulletController {
  @Autowired
  BulletinRepository bulletinRepository;
  @GetMapping("/bulletin")
  public List<Bulletin> findall() {
	return  bulletinRepository.findAll();
  }
  //获取指定id的公告信息
  @GetMapping("/{id}")
  public Bulletin findone(@PathVariable String id) {
	return  bulletinRepository.findById(id).get();
  }
  //删除公告信息
  @DeleteMapping("/bulletin/{id}")
  public void delone(@PathVariable String id) {
	  bulletinRepository.deleteById(id);
  }
  //通过id修改公共信息
  @PutMapping("/bulletin")
  public  Bulletin  puts(@RequestBody Bulletin bulletin) {
	  bulletinRepository.findById(bulletin.getId()).get();
	  return bulletinRepository.save(bulletin);
  }
  //添加公告
  @PostMapping("/bulletin")
  public Bulletin add(@RequestBody Bulletin bulletin) {
	  return bulletinRepository.save(bulletin);
  }
  //通过标题模糊查询公告
  @GetMapping("/bulletin/{title}")
  public List<Bulletin> find(@PathVariable String title) {
	  System.out.println("傻逼");
	  return bulletinRepository.fas(title);
  }
}
