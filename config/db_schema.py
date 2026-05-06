"""
Database schema definition for the e-commerce system.

This module defines the structure of the database tables based on the Entity-Relationship Diagram.
"""

import uuid

class User:
    """Represents a user in the system."""
    def __init__(self, user_id: uuid.UUID, first_name: str, last_name: str, address: str, email: str):
        self.user_id: uuid.UUID = user_id
        self.first_name: str = first_name
        self.last_name: str = last_name
        self.address: str = address
        self.email: str = email

    def __repr__(self):
        return f"User(user_id='{self.user_id}', first_name='{self.first_name}', last_name='{self.last_name}', email='{self.email}')"


class Product:
    """Represents a product in the system."""
    def __init__(self, product_id: uuid.UUID, product_name: str, description: str, price: int):
        self.product_id: uuid.UUID = product_id
        self.product_name: str = product_name
        self.description: str = description
        self.price: int = price

    def __repr__(self):
        return f"Product(product_id='{self.product_id}', product_name='{self.product_name}', price={self.price})"


class Order:
    """Represents an order placed by a user for a product."""
    def __init__(self, order_id: uuid.UUID, user_id: uuid.UUID, product_id: uuid.UUID, total_paid: int):
        self.order_id: uuid.UUID = order_id
        # Foreign key to User.user_id
        self.user_id: uuid.UUID = user_id
        # Foreign key to Product.product_id
        self.product_id: uuid.UUID = product_id
        self.total_paid: int = total_paid

    def __repr__(self):
        return f"Order(order_id='{self.order_id}', user_id='{self.user_id}', product_id='{self.product_id}', total_paid={self.total_paid})"


# Example of how you might use these classes (optional, for illustration)
if __name__ == "__main__":
    # Creating sample data
    sample_user = User(
        user_id=uuid.uuid4(),
        first_name="John",
        last_name="Doe",
        address="123 Main St, Anytown, USA",
        email="john.doe@example.com"
    )

    sample_product = Product(
        product_id=uuid.uuid4(),
        product_name="Laptop",
        description="A powerful portable computer",
        price=1200
    )

    sample_order = Order(
        order_id=uuid.uuid4(),
        user_id=sample_user.user_id,
        product_id=sample_product.product_id,
        total_paid=1200
    )

    print(sample_user)
    print(sample_product)
    print(sample_order)
