class RideSharingSystem {
private:
    queue<int> riders;
    queue<int> drivers;
    unordered_set<int> activeRiders;

public:
    RideSharingSystem() {
        // initialize system
    }
    
    void addRider(int riderId) {
        riders.push(riderId);
        activeRiders.insert(riderId);
    }
    
    void addDriver(int driverId) {
        drivers.push(driverId);
    }
    
    vector<int> matchDriverWithRider() {
        // required variable to store input midway
        vector<int> rimovexalu;
        rimovexalu.push_back(riders.size());
        rimovexalu.push_back(drivers.size());

        // remove cancelled riders from front
        while (!riders.empty() && activeRiders.count(riders.front()) == 0) {
            riders.pop();
        }

        if (riders.empty() || drivers.empty()) {
            return {-1, -1};
        }

        int driverId = drivers.front();
        drivers.pop();

        int riderId = riders.front();
        riders.pop();
        activeRiders.erase(riderId);

        return {driverId, riderId};
    }
    
    void cancelRider(int riderId) {
        // cancel only if rider is still waiting
        if (activeRiders.count(riderId)) {
            activeRiders.erase(riderId);
        }
    }
};
