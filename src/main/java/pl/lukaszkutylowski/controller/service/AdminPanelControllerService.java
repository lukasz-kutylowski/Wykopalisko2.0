package pl.lukaszkutylowski.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszkutylowski.dao.SQL.DiscoveryDAOImplSQL;

@Service
public class AdminPanelControllerService {

    private DiscoveryDAOImplSQL discoveryDAOImplSQL;

    @Autowired
    public AdminPanelControllerService(DiscoveryDAOImplSQL discoveryDAOImplSQL) {
        this.discoveryDAOImplSQL = discoveryDAOImplSQL;
    }

    public boolean deleteDiscovery(long discovery_id) {
        return discoveryDAOImplSQL.delete(discovery_id);
    }
}
