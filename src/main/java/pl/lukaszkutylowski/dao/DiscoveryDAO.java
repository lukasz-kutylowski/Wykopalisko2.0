package pl.lukaszkutylowski.dao;

import java.util.List;

import pl.lukaszkutylowski.model.Discovery;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long> {

	List<Discovery> getAll();
}
