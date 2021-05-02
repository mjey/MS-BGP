# What is MS-BGP?
MS-BGP is a hardware/protocol level project that facilitates peer-to-peer internet
connectivity by using trustless exploration of how isolated nodes are linked as
well as indirect paths across the mesh between nodes.
## What makes MS-BGP awesome?
Free communications.
* Largely eliminates the need for ISPs in most non-rural settings.
* Decentralized mesh of nodes; no regulation.
* All communications are encrypted end-to-end by default.
* Permissionless server and file hosting.
* Resilient to large-scale crises via learning and redundant pathing.
* Very simple hardware required for easy and cheap connection setup in
remote/undeveloped/volatile locations and environments.
* There will be no more IP addresses, DNS servers, or domain registration. A
decentralized and trustless blockchain can have name lookup.
* Contact over very long (possibly interplanetary) distances is possible with
asynchronous and stateless links. 
## Terms
* **Neighbor:** A neighbor is a node with hop count 1 (directly bound to the
self-node). A neighborship is a relation between two nodes.
* **Ping:** Time, in milliseconds, between a sent ping and a ping response.
* **Self-Node:** The node on which the host program runs, with its own
database and features.
* **Parcel:** A piece of data.
* **Pallet:** On the receiving node, a set of packets that make up a big piece of
info.
* **Signal:** A high-level term for a complete pallet made up of parcels,
assuming that it is in working order.
* **Remote-Node or Node:** A node that isn't a self-node.
* **Community:** Group nodes are those that are under a user-defined hop
count. Communities communicate with one another by sharing pathways
and announcing their presence.
* **Hops:** The number of links traversed between two nodes is used to
calculate the distance between them. Self-node is hop-0, neighbor is hop1, and so on.
* **Stop:** A single node in a path.
* **Path:** A path between two nodes, made up of stops.
* **Pinned Node:** To allow for fast communication, a remote node should
always have an established and checked route to the self-node.
* **Trusted Node:** The self-node has granted "trusted status" to a remote
node. Trusted nodes are queried for path information. Both trustworthy
nodes behave like pinned nodes by default.
* **Mailbox:** The parcels' inbound/outbound coordinator. Builds pallets and
then delivers them to the self-node.
* **Ping (Pallet Type):** To verify online status or latency, send a one-parcel
request to a server.
* **Ping Response (Pallet Type):** Response to a ping.
* **Discover (Pallet Type):** Request details about a particular node's route.
* **Discover Response (Pallet Type):** Response to a discover request.
* **Data (Pallet Type):** Standard parcel that contains a normal data transfer.
* **Data Receipt (Pallet Type):** After completing a pallet, the receiving node
sends a receipt to the originator. 
* **Adversarial Node:** A node connecting to an MS-BGP network that does
not adhere to the majority protocol or fair connection
guidelines/obligations. 
## Functions
### Node Birth
When a node is first connected to the network, it has no idea of what it is doing.
It's possible that this is a new installation or that the user deleted the folder. A
number of incidents will occur:
1. Have a private/public key pair.
2. Let your presence known in the culture.
Asking for a Path
When a path to a node is uncertain, seek assistance from any supportive nodes.
1. Send a discover signal to any member of the network, along with the
requested node address.
2. Keep an eye out for answers.
3. Each returned path should be added to the "known paths" variable of the
node.
4. Instruct the node object to replace any obsolete routes. (All paths will be
changed so no paths were ever pinged.)
5. We will decide which group members are being truthful in the long run
because pathways have a "recommended by" variable to see where the
route information originated from.
### UI
Dashboard
• The community's online status/ping
• Pinging/online state of pinned nodes (which includes trusted nodes,
trusted nodes listed first)
Active Pallets
• List’s data parcels awaiting receipt.
Node Profile
• Relationship setting ("None", "Pinned", "Trusted and Pinned")
• Success rates
• Volume statistics
Future Incentive Structure
What prevents a node from reacting to ping chunks but failing to forward data?
Incentives help to solve a lot of the network's confidence problems. It also allows
nodes to pop up and assist the network in congested areas, similar to how
mining bitcoin increases the network's stability. It's a means of encouraging
individuals to be greedy but still vitally assisting the network. Forward data
chunks are rewarded with cryptocurrencies as a reward. 
1. A node can only receive a data chunk from another node if it is either an
intermediate hop on the way to the final destination or the final
destination itself.
2. This implies that before sending a data chunk out, the direction it would
take to reach its destination must be identified.
3. A transaction hash is included in the message's text, which transfers
cryptocurrencies to all node hops. This exchange hash is encrypted with
the final destination's public key, with the final destination being another
awarded node. This number would most likely be so minimal that paying it
would not be a challenge for the SelfNode. Furthermore, the SelfNode has
most certainly assisted in the forwarding of messages, so they can, in
principle, be receiving as much as they are investing.
4. When the message (and therefore the transaction) arrives at the path's
endpoint, the destination decrypts the transaction hash and verifies that
they, as well as the other nodes along the path, will be paid.
5. They'll broadcast the post, and the exchange will incentivize further
connections by rewarding all hops along the way.
6. If hops in the path aren't paid, they will blacklist the link between the target
and the destination, refusing to serve the path while these two are at
opposite ends. This ensures that both the target and the SelfNode are
encouraged to cooperate with the hops and complete the activity deal.
## CSE Versions
A **controlled simulation environment (CSE)** is a simulated network that is used
to assess the features of MS-BGP. The utility stems from the use of an identical
network across various simulation rounds for bug detection, function checking,
and data collection.
## CSE v1
There are eight nodes and four parcels. Two parcels have optimal routes of
lengths of two (the shortest possible), while the rest have longer paths. There is
one dormant adversarial node.
## CSE v2
There are 100 nodes and 50 parcels. Neighborships are created using four integer
arrays. For instance, if there were ten nodes, the neighborships arrays could look
like this:
```http
[3, 2, 1, 3, 3, 2, 1, 1, 2]
[1, 3, 4, 2, 0, 4, 0, 4, 0]
[2, 1, 2, 1, 3, 2, 3, 1, 0]
[1, 0, 0, 0, 4, 2, 2, 2, 1]
```
The offset from the current node to the neighbor node is defined by the integer.
This means that node **n0** is connected to **n3 (n0 + 3)**, **n1 (n0 + 1)**, and **n2 (n0 +2)**. There may be no duplicates, because if a neighborship value is **0**, it means the
object does not exist. If one of the last nodes is after the end of the node list, a
modulo is used. The number of neighborship arrays ranges between **0** and **4**. (the
number of neighborship arrays). The neighborship arrays are created randomly
only once during the code writing process and are thus hardcoded to be the
same for all future simulations.
The 50 parcels are organized in an array as follows:
```http
[32, 20],
[27, 19],
[18, 49],
```
The first value is the node, which is represented by the index in the node_set list.
The data content of each parcel is the string **"parcel data_" + n**, where n is the
parcel list index. 
### Duplication Protection
#### Duplication Issue
In MS-BGP interactions, duplication is unavoidable. In standard internet
protocols, this problem is solved by using a sequence number to
distinguish packets in a network. Since MS-BGP operates in a zero-trust,
stateless, mesh-based environment, duplicate parcels can occur even more
frequently from both regular operation and attackers. Duplicate parcels
without safeguards can have the effect of repeatedly performing remote
activities, such as sending a text message or completing a bank transaction.
#### Bad Solution: Attached Unix Time
Since only the sender can create a cryptographically valid parcel, they must
have a Unix time that the recipient can verify. This will not fit for a number
of reasons:
* It is possible if the sender and receiver are not in the same time zone.
* The length of time it takes for a package to arrive at its destination
should be irrelevant.
* There is a valid time window within which duplicates can be
successfully obtained.
#### Solution to be Implemented
A safer approach will be to keep a long integer sequence_number for each
RemoteNode. We increment the attached sequence_number whenever
we send a Parcel to the destination (including retries). The receiver would
then save a copy of all sequence_numbers received from a single remote
node, ignoring duplicates. To conserve space, the receiver can merge their
sequence_numbers after a certain amount of time into a
min_sequence_number that is equal to the largest stored
sequence_number. In essence, we disregard any parcel that satisfies any of
the following criteria:
* parcel_sequence_number <= min_sequence_number
* received_sequence_numbers.contains(parcel_sequence_number)
#### Improving the Solution
Due to the way the valid sequence number consolidation happens, large data
payloads will need to be retried if they are in the process of being sent when a
**consolidation happens.<br>
received_sequence_numbers array = [5,6,7,8,10]<br>
min_sequence_number = 4<br>
Consolidation happens because the array is size 5.<br>
received_sequence_numbers array = []<br>
min_sequence_number = 10<br>**
When the lost parcel 9 is delivered, it will no longer be valid. The sender will wait
for it to become stale before re-sending with a higher sequence number. There
are a couple improvements to minimize this issue.<br>
Upon receiving a parcel, if **parcel_sequence_number == (min_sequence_number + 1)**
then we will simply increment min_sequence_number. This will shrink the size of the
received_sequence_numbers array.<br>
Also, occasionally scan received_sequence_numbers for values that are
**received_sequence_numbers.get(i) == (min_sequence_number + 1)** and
remove index i while updating the min_sequence_number. This would
significantly minimize the received_sequence_numbers list so it would only fill
with sequence numbers with holes in them, so these should fill in easily and,
theoretically, once one data parcel gets there, another does not have a problem a
few milliseconds later. We'll hold "hard" restructuring in place, but it shouldn't
happen as much as it did before the changes.
#### Running out of sequence numbers?
The maximum value for the Java long form is **9,223,372,036,854,775,807**. If you
interacted with a single remote node per nanosecond (billion times per second),
you'd run out of sequence numbers in 292 years. If you hit this quota, simply
update your node address.
## Paths vs. Chains
A chain is a plain, isolated, final data form that represents a connection between
nodes. A chain might look like this: **"A->B->C->D."** A path, on the other hand, is
a chain that includes consumption statistics. Paths are not typically exchanged so
there is no way to trust another node's utilization statistics of a path. Chains are
intended to be publicly transmitted, and they are the data form associated with
serialized packets.<br>
Except in a few instances, such as serialization of parcels or changing Path object
code, it is common for MS-BGP objects to use Path instead of Chain for all
variables.
Payload Types
* **Ping**
    * **Require Tested Path:** No
    * **Resolve Unknown Path:** Yes
* **PingResponse**
    *  **Require Tested Path:** No
    *  **Resolve Unknown Path:** Yes
* **Find**
    * **Require Tested Path:** Yes
    * **Resolve Unknown Path:** No
* **FindResponse**
    * Require Tested Path: Yes
    * Resolve Unknown Path: Yes
* **Data**
    * **Require Tested Path:** Yes
    * **Resolve Unknown Path:** Yes
* **DataResponse**
    * **Require Tested Path:** Yes
    * **Resolve Unknown Path:** Yes
* **Announce**
    * Require Tested Path: No
    * Resolve Unknown Path: No

#### Steps to Send Parcel
1. Create a parcel object and supply it a destination.
2. Create a payload of the desired type and give it to the parcel.
3. Hand the parcel off to the handshake manager. The mailbox will have a
reference to the handshake manager.
4. The handshake manager (HandshakeHistory) will repeatedly check if the
parcel is ready to be sent, and will send the necessary find or ping
parcels to make the parcel ready to be sent.
5. Once the handshake manager notices that the parcel is ready for
sending, the parcel is removed from the pending list and is given to the
mailbox outbound queue.
6. The mailbox will eventually process the parcel in the outbound queue.
The parcel is then handed off to the network controller, which will read
the next node, serialize, and then send it across the appropriate
neighbor port.
7. The handshake manager will continuously recheck to see if there is a
response yet to the handshake. After a "stale" time, the parcel is resent.
After several resend attempts, the parcel is considered "failed", updating
the path statistics accordingly.
## Success Statistics
One essential feature of an MS-BGP node is to hold data on the performance of
contacting specific nodes, the helpfulness of nodes, and which specific paths are
functional. This numbers are organized into groups.
* **Assist:** An assist is a simple incremented integer stored in each
RemoteNode. Every time a parcel is received, we give an assist to each
node in the node chain attached to the parcel.
* **Successes/Failures:** Each path has statistics about the contained node
chain, relative to self. Successes/failures come into play when we are
sending parcels as the originator. When sending, a handshake is created
as we await a response. If the handshake goes stale, (a.k.a. "timeout") we 
increment failures on the path. If we receive a response, we increment
successes for the path.
* **Reliability:** Reliability is a specially calculated score to judge, on a scale
of 0.0-1.0, how reliable the path is. If a path has fewer than 5 attempted
uses, the path gets constant reliability score of 0.75 regardless of actual
success rate. If a path has more than 5 attempted uses, the formula for
determining reliability is as follows:<br>
**reliability = (successes() * (1 + PATH_RELIABILITY_BONUS)) / totalUses();**<br>
Where **PATH_RELIABILITY_BONUS = 0.05** by default. Effectively, this formula will
"forgive" about 5% of failures. This means that long-standing successful paths
won't be unfairly hit if they go down temporarily. When there are multiple longstanding successful paths, small differences in "actual" reliability score shouldn't
matter: they should remain equally reliable at the max score of 1.0.
