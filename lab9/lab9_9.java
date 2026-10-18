package lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Particle {
    private long energy;

    public Particle(long energy) {
        this.energy = energy;
    }

    public long getEnergy() {
        return energy;
    }

    public void setEnergy(long energy) {
        this.energy = energy;
    }
}

class ParticleSystem {
    private List<Particle> particles;
    private long totalEnergy;

    public ParticleSystem() {
        this.particles = new ArrayList<>();
        this.totalEnergy = 0;
    }

    public void addParticle(long energy) {
        this.particles.add(new Particle(energy));
    }

    public int findBestCollisionPairIndex() {
        if (particles.size() < 2) {
            return -1;
        }
        int bestIdx = -1;
        long maxDiff = -1;
        for (int i = 0; i < particles.size() - 1; i++) {
            long diff = Math.abs(particles.get(i).getEnergy() - particles.get(i + 1).getEnergy());
            if (diff > maxDiff) {
                maxDiff = diff;
                bestIdx = i;
            }
        }
        return bestIdx;
    }

    public boolean collideBestPair() {
        int idx = findBestCollisionPairIndex();
        if (idx == -1) {
            return false;
        }
        long releasedEnergy = Math.abs(particles.get(idx).getEnergy() - particles.get(idx + 1).getEnergy());
        totalEnergy += releasedEnergy;
        particles.remove(idx + 1);
        particles.remove(idx);
        return true;
    }

    public long simulate() {
        while (particles.size() >= 2) {
            collideBestPair();
        }
        return totalEnergy;
    }

    public long getTotalEnergy() {
        return totalEnergy;
    }
}

public class lab9_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int N = sc.nextInt();
        ParticleSystem system = new ParticleSystem();
        for (int i = 0; i < N; i++) {
            system.addParticle(sc.nextLong());
        }
        System.out.println(system.simulate());
    }
}
