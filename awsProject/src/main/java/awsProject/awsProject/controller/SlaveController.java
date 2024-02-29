package awsProject.awsProject.controller;

import awsProject.awsProject.database.entity.Slave;
import awsProject.awsProject.service.SlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slaves")
public class SlaveController {

    @Autowired
    private SlaveService slaveService;

    @GetMapping
    public ResponseEntity<List<Slave>> getAllSlaves() {
        List<Slave> slaves = slaveService.getAllSlaves();
        if (!slaves.isEmpty()) {
            return ResponseEntity.ok(slaves);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Slave> getSlaveById(@PathVariable Long id) {
        Optional<Slave> slave = slaveService.getSlaveById(id);
        return slave.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/boss/{bossId}")
    public ResponseEntity<List<Slave>> getSlavesByBoss(@PathVariable Long bossId) {
        List<Slave> slaves = slaveService.getSlavesByBoss(bossId);
        if (!slaves.isEmpty()) {
            return ResponseEntity.ok(slaves);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Slave> createSlave(@RequestBody Slave slave) {
        Slave savedSlave = slaveService.saveSlave(slave);
        if (savedSlave != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSlave);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Slave> updateSlave(@PathVariable Long id, @RequestBody Slave slaveDetails) {
        Optional<Slave> updatedSlave = slaveService.updateSlave(id, slaveDetails);
        return updatedSlave.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSlave(@PathVariable Long id) {
        slaveService.deleteSlave(id);
        return ResponseEntity.noContent().build();
    }
}

