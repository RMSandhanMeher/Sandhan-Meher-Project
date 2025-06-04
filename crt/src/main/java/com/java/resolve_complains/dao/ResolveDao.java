package com.java.resolve_complains.dao;

import java.util.List;

import com.java.resolve_complains.model.Resolve;

public interface ResolveDao {
public String resolve(Resolve resolve) throws Exception;
public List<Resolve> showResolves();
public Resolve searchResolveByComplaintId(String complaintId);


}
