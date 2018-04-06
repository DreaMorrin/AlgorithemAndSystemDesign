### Question to ask ###
Questions to ask:
1. Do you want me to OO design or system design Handling Ambiguity

2. Clarify the details (Systematic Approach)
	- How is this parking lot designed? Building ? Open space? Accessibility?
	- How many spots are we talking about? in multiple building?
	- How many levels for the parking lot?
	- How many entries are there for the parking lot? Concurrency issue
	- Shall we fill up certain levels? Optimization?
	- What kind of spots do we have? Pricing of the parking spot ?
	
3. Derive to OO Design

4. Certain methods implementation

5. How you are going to deal with this when it comes to scalability

    A: 
    1. We will have client followed by our backend server load balancer.
    2. Load balancer is followed by multiple backend servers
    3. Backend servers will be followed by a DB load balancer
    4. DB load balancer is followed by a master DB instance, and the master is followed by multiple slaves
    (Answer the most efficient approach: Multiple master, multiple load balancer and multiple data center)
    vehicle | L | -> ParkingLot -> entrance1 +--| L | -> DB(master), DB1, DB2 (Shared Distributed DB)
            | O |               -> entrance2 +--| O |
            | A |                               | A |
            | D | -> ParkingLot -> entrance1 +--| D | -> DB(master), DB1, DB2 (Shared Distributed DB)
            | B |               -> entrance2 +--| B |
            | A |                               | A |
            | L | -> ParkingLot -> entrance1 +--| L | -> DB(master), DB1, DB2 (Shared Distributed DB)
            | A |               -> entrance2 +--| A |
            | N |                               | N |
            | C | -> ParkingLot -> entrance1 +--| C | -> DB(master), DB1, DB2 (Shared Distributed DB)
            | E |               -> entrance2 +--| E |
            | R |                               | R |
            
     Ways to scale:
        1. Load balancer
        2. Scatter and Gather
        3. Result Cache
            - Cache server at the load balancer side
            - Distributed Caches on servers
        4. Shared spaces - each part of the result will be computed by a component.
            Results will be gathered into the central space
        5. Pipe and Filter - (request in queue -> response in queue)
            Can be used in parking lot
        6. Map reduce
        7. 
    
6. How you are going to deal with this when it comes to consistency
	- Let's say you have multiple parking lot in different places, they have different data center. How you are going to modify it?
	- What consistency you are asking? Is it for DB level of just application level?
	When storing a record in database, masters will check on each other make sure there is no dirty write.
	But for sharded database, we don't need this check
	
	
7. How you are going to deal with this when it comes to concurrency
	- Let's say you have multiple entrance, how you are going to modify the design?
	