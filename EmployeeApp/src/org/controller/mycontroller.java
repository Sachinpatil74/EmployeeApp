package org.controller;

import java.util.List;

import org.Dao.Edao;
import org.beans.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mycontroller {
@Autowired
public Edao edao;
@Autowired
public Emp e;
@RequestMapping("/addemp")
public String addEmp(@RequestParam("id") int id,@RequestParam("name") String name)
{
	e.setId(id);
	e.setName(name);
	int i=edao.addEmp(e);
	if(i>0)
	{
		return "added";
	}
	else
	{
		return "notadded";
	}
}
@RequestMapping("/delemp")
public String deleteEmp(@RequestParam("id") int id,Model m)
{
	edao.delEmp(id);
	List<Emp> al=edao.show();
	m.addAttribute("data",al);
	return "view";
}
@RequestMapping("/view")
public String viewData(Model m)
{
	List<Emp> al=edao.show();
	m.addAttribute("data",al);
	return "view";
}
}
