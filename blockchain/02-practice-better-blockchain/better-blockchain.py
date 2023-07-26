import hashlib
import json
import time

class BlockChain:
    
    def __init__(self):
        self.chain = []  # Initialize an empty list to store blockchain blocks.
    
    def creating_new_block(self, user_id, coin_name, value_trx):
        if not self.chain:  # Check if the chain is empty (no blocks created yet).
            print('You should create the first block and do hash default chain ')
        else:
            new_block = {
                'previous_hash': self.hash_block(self.chain[-1]),  # Get the hash of the previous block.
                'user_id': user_id,
                'coin_name': coin_name,
                'value_trx': value_trx,
                'timestamp': time.time()  # Add the current timestamp to the block.
            }
            self.chain.append(new_block)  # Append the new block to the blockchain.
            return new_block
    
    def adding_first_block(self, user_id, coin_name, value_trx):
        default_block = {
            'user_id': user_id,
            'coin_name': coin_name,
            'value_trx': value_trx,
            'timestamp': time.time()  # Add the current timestamp to the block.
        }
        self.chain.append(default_block)  # Append the first block to the blockchain.
        return default_block
    
    def hash_block(self, block):
        to_str_ = json.dumps(block, sort_keys=True)  # Convert the block dictionary to a JSON string.
        return hashlib.sha256(to_str_.encode()).hexdigest()  # Return the SHA-256 hash of the JSON string.
    
    def last_block(self):
        if not self.chain:  # Check if the chain is empty (no blocks created yet).
            return None
        return self.chain[-1]  # Return the last block in the blockchain.

