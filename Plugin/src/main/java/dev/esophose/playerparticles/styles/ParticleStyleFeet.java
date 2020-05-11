package dev.esophose.playerparticles.styles;

import dev.esophose.playerparticles.particles.PParticle;
import dev.esophose.playerparticles.particles.ParticlePair;
import dev.esophose.playerparticles.config.CommentedFileConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;

public class ParticleStyleFeet extends DefaultParticleStyle {

    private float feetOffset;
    private float particleSpreadX, particleSpreadY, particleSpreadZ;
    private float particleSpeed;
    private int particlesPerTick;

    public ParticleStyleFeet() {
        super("feet", true, false, 0.5);
    }

    @Override
    public List<PParticle> getParticles(ParticlePair particle, Location location) {
        List<PParticle> particles = new ArrayList<>();
        for (int i = 0; i < this.particlesPerTick; i++)
            particles.add(new PParticle(location.clone().add(0, this.feetOffset, 0), this.particleSpreadX, this.particleSpreadY, this.particleSpreadZ, this.particleSpeed));
        return particles;
    }

    @Override
    public void updateTimers() {

    }

    @Override
    protected void setDefaultSettings(CommentedFileConfiguration config) {
        this.setIfNotExists("feet-offset", -0.95, "How far to offset the player location vertically");
        this.setIfNotExists("particle-spread-x", 0.4, "How far to spread the particles on the x-axis");
        this.setIfNotExists("particle-spread-y", 0.0, "How far to spread the particles on the y-axis");
        this.setIfNotExists("particle-spread-z", 0.4, "How far to spread the particles on the z-axis");
        this.setIfNotExists("particle-speed", 0.0, "The speed of the particles");
        this.setIfNotExists("particles-per-tick", 1, "How many particles to spawn per tick");
    }

    @Override
    protected void loadSettings(CommentedFileConfiguration config) {
        this.feetOffset = config.getFloat("feet-offset");
        this.particleSpreadX = config.getFloat("particle-spread-x");
        this.particleSpreadY = config.getFloat("particle-spread-y");
        this.particleSpreadZ = config.getFloat("particle-spread-z");
        this.particleSpeed = config.getFloat("particle-speed");
        this.particlesPerTick = config.getInt("particles-per-tick");
    }

}