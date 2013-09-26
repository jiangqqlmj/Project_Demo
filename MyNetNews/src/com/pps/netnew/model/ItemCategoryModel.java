package com.pps.netnew.model;

/**
 * ��ߵײ������� item����Ϣʵ����
 * 
 * @author jiangqingqing
 * 
 */
public class ItemCategoryModel {
	private Integer id; // ͼ�����Դid
	private String name;// ���item������
	private String title; // ����item��Ӣ������

	public ItemCategoryModel() {
		super();
	}

	public ItemCategoryModel(Integer id, String name, String title) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ItemCategoryModel [id=" + id + ", name=" + name + ", title="
				+ title + "]";
	}

}
